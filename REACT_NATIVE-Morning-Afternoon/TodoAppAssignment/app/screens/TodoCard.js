import React from "react";
import { StyleSheet, Text, View, TouchableOpacity } from "react-native";
import { floor } from "react-native-reanimated";

import AsyncStorage from "@react-native-community/async-storage";

export default function TodoCard(props) {
  const TODOS = "@todos";
  const onDelete = async () => {
    // try {
    //   let oldTodos = await AsyncStorage.getItem(TODOS);
    //   const restoredArray = JSON.parse(oldTodos);
    //   const removeArr = [...restoredArray].filter(
    //     (itemf) =>
    //       props.todoData.title !== itemf.title &&
    //       props.todoData.desc == itemf.desc
    //   );
    //   await AsyncStorage.setItem(TODOS, JSON.stringify(removeArr));
    // } catch (e) {
    //   alert(e);
    // }
  };
  return (
    <View style={styles.container}>
      <View style={styles.containerText}>
        <Text style={styles.text}>Title: {props.todoData.title}</Text>
        <Text style={styles.text}>Desc: {props.todoData.desc}</Text>
      </View>
      {/* <TouchableOpacity style={styles.deleteBtn} onPress={onDelete}>
        <Text style={styles.delText}>Delete</Text>
      </TouchableOpacity> */}
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    width: 280,
    margin: 10,
    backgroundColor: "#2c3e50",
    alignItems: "center",
    color: "white",
    justifyContent: "center",
  },
  containerText: {
    flex: 1,
    width: "100%",
    justifyContent: "flex-start",
  },
  text: {
    height: 30,
    width: "100%",
    marginTop: 5,
    color: "white",
    fontSize: 20,
    paddingLeft: 10,
    alignItems: "flex-start",
    justifyContent: "flex-start",
  },
  deleteBtn: {
    height: 30,
    color: "white",
    fontSize: 20,
    margin: 8,
    width: "95%",
    margin: 5,
    backgroundColor: "#34495e",
    alignItems: "flex-start",
    justifyContent: "flex-start",
  },
  delText: {
    height: 30,
    width: "100%",
    color: "white",
    fontSize: 16,
    padding: 5,

    alignItems: "flex-start",
    justifyContent: "flex-start",
  },
});
