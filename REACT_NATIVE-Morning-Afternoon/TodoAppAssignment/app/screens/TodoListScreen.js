import React, { useState, useEffect } from "react";
import {
  View,
  StyleSheet,
  Text,
  TouchableOpacity,
  ScrollView,
} from "react-native";

import AsyncStorage from "@react-native-community/async-storage";
import TodoCard from "./TodoCard";
export default function TodoListScreen(props) {
  const TODOS = "@todos";
  const [todosExist, settodosExist] = useState(false);
  const checkTodosStorage = async () => {
    try {
      const oldTodos = await AsyncStorage.getItem(TODOS);
      // setTodos(oldTodos)
      if (oldTodos !== null) {
        settodosExist(true);
        setTodos(JSON.parse(oldTodos));
      } else {
        settodosExist(false);
      }
    } catch (e) {
      alert("Error " + e);
    }
  };

  useEffect(() => {
    checkTodosStorage();
  }, []);
  const [Todos, setTodos] = useState([]);

  const onAddClick = () => {
    props.navigation.navigate("AddTodo");
  };

  return (
    <View style={styles.container}>
      <ScrollView
        showsVerticalScrollIndicator={false}
        showsHorizontalScrollIndicator={false}
      >
        <TouchableOpacity style={styles.addBtn}>
          <Text style={styles.btnText} onPress={onAddClick}>
            ADD NEW TODO
          </Text>
        </TouchableOpacity>
        {todosExist !== true ? (
          <Text style={styles.noTodos}>NO TODOS :)</Text>
        ) : null}
        <View style={styles.listContainer}>
          {Todos.map((todoData, i) => (
            <TodoCard todoData={todoData} key={i} />
          ))}
        </View>
      </ScrollView>
    </View>
  );
}
const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 10,
    backgroundColor: "#34495e",
    alignItems: "center",
  },
  listContainer: {
    flex: 1,
  },
  noTodos: {
    flexGrow: 1,
    marginTop: "50%",
    fontSize: 30,

    color: "white",
  },
  input: {
    borderRadius: 8,
    marginTop: 20,
    height: 40,
    width: 300,
    backgroundColor: "#95a5a6",
    paddingHorizontal: 10,
    color: "white",

    fontSize: 18,
  },
  addBtn: {
    marginTop: 20,
    height: 50,
    width: 300,
    marginBottom: 20,

    borderRadius: 8,
    backgroundColor: "#2c3e50",
    paddingHorizontal: 10,
    color: "white",
    fontSize: 18,
  },
  btnText: {
    paddingVertical: 13,
    textAlign: "center",
    fontSize: 20,
    color: "white",
  },
});
