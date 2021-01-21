import { StatusBar } from "expo-status-bar";
import React from "react";
import { StyleSheet, Text, View } from "react-native";
import LoginScreen from "./app/screens/LoginScreen";
import TodoListScreen from "./app/screens/TodoListScreen";
import { NavigationContainer } from "@react-navigation/native";
import { createStackNavigator } from "@react-navigation/stack";
import AddTodoScreen from "./app/screens/AddTodoScreen";
const Stack = createStackNavigator();
export default function App() {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="Login" component={LoginScreen} />
        <Stack.Screen name="TodoList" component={TodoListScreen} />
        <Stack.Screen name="AddTodo" component={AddTodoScreen} />
      </Stack.Navigator>
    </NavigationContainer>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    // backgroundColor: "teal",
    alignItems: "center",
    justifyContent: "center",
  },
});
