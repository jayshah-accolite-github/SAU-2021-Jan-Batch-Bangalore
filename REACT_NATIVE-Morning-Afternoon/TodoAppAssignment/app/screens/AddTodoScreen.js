import React, { useState, useEffect } from "react";
import AsyncStorage from "@react-native-community/async-storage";
import {
  View,
  StyleSheet,
  Text,
  TouchableOpacity,
  TextInput,
} from "react-native";

export default function AddTodoScreen(props) {
  const TODOS = "@todos";

  const [Title, setTitle] = useState("");
  const [Desc, setDesc] = useState("");
  const checkTodosStorage = async () => {
    try {
      const oldTodos = await AsyncStorage.getItem(TODOS);
      // setTodos(oldTodos)
      if (oldTodos !== null) {
        return oldTodos;
      } else {
        return [];
      }
    } catch (e) {
      return [];
    }
  };

  const onTitleChange = (text) => {
    setTitle(text);
  };
  const onDescChange = (text) => {
    setDesc(text);
  };
  const addInList = async () => {
    if (Title !== "" && Desc !== "") {
      let oldTodos = null;
      try {
        oldTodos = await AsyncStorage.getItem(TODOS);
        // setTodos(oldTodos)
        if (oldTodos !== null) {
          const restoredArray = JSON.parse(oldTodos);
          const newTodos = [{ title: Title, desc: Desc }, ...restoredArray];
          await AsyncStorage.setItem(TODOS, JSON.stringify(newTodos));
          props.navigation.replace("TodoList");
        } else {
          const newTodos = [{ title: Title, desc: Desc }];
          await AsyncStorage.setItem(TODOS, JSON.stringify(newTodos));
          props.navigation.replace("TodoList");
        }
      } catch (e) {
        alert(e);
      }
    } else {
      alert("Give all details");
    }
  };

  return (
    <View style={styles.container}>
      <TextInput
        placeholder="Title"
        onChangeText={(text) => onTitleChange(text)}
        value={Title}
        style={styles.input}
      />
      <TextInput
        placeholder="Description"
        onChangeText={(text) => onDescChange(text)}
        value={Desc}
        style={styles.input}
      />

      <TouchableOpacity style={styles.addBtn} onPress={addInList}>
        <Text style={styles.btnText}>ADD TO LIST</Text>
      </TouchableOpacity>
    </View>
  );
}
const styles = StyleSheet.create({
  container: {
    flex: 1,

    backgroundColor: "#34495e",
    alignItems: "center",
    justifyContent: "center",
  },
  logoContainer: {
    flexGrow: 1,
    alignItems: "center",
    justifyContent: "center",
  },
  logo: {
    height: 100,
    marginLeft: 20,
    width: 100,
  },
  text: {
    color: "white",
  },
  title: {
    marginTop: 20,
    textAlign: "center",
    fontSize: 20,
    color: "white",
  },
  loginContainer: {
    paddingBottom: 50,
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
