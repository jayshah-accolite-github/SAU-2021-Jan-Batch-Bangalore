import React from "react";
import { StyleSheet, Text, View } from "react-native";

export default function TodoCard(props) {
  return (
    <View style={styles.container}>
      <Text style={styles.text}>Title: {props.todoData.title}</Text>
      <Text style={styles.text}>Desc: {props.todoData.desc}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    height: 80,
    width: 280,
    margin: 10,
    backgroundColor: "#2c3e50",
    alignItems: "center",
    color: "white",
    justifyContent: "center",
  },
  text: {
    height: 30,
    width: "100%",
    color: "white",
    fontSize: 20,
    paddingLeft: 10,
    alignItems: "flex-start",
    justifyContent: "flex-start",
  },
});
