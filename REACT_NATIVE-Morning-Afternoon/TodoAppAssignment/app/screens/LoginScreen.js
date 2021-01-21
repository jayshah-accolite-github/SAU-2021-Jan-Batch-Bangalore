import React, { useState, useEffect } from "react";
import AsyncStorage from "@react-native-community/async-storage";

import { NavigationContainer } from "@react-navigation/native";
import { createStackNavigator } from "@react-navigation/stack";
import {
  StyleSheet,
  Text,
  Image,
  View,
  TextInput,
  TouchableOpacity,
  Alert,
} from "react-native";
import TodoListScreen from "./TodoListScreen";

function LoginScreen(props) {
  useEffect(() => {
    checkLogin();
    // clearStorage();
  }, []);

  const USERNAME = "@username";
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const onUsernameChange = (text) => {
    setUsername(text);
  };
  const onPasswordChange = (text) => {
    setPassword(text);
  };
  const clearStorage = async () => {
    try {
      await AsyncStorage.clear();
      alert("Storage successfully cleared!");
    } catch (e) {
      alert("Failed to clear the async storage.");
    }
  };
  const onLogin = async () => {
    try {
      if (username !== "" && password !== "") {
        await AsyncStorage.setItem(USERNAME, username);
        props.navigation.replace("TodoList");
      } else {
        Alert.alert("Enter all details");
      }
    } catch (error) {
      Alert.alert("" + error);
      console.log(error);
    }
  };
  const checkLogin = async () => {
    try {
      const userName = await AsyncStorage.getItem(USERNAME);

      if (userName !== null) {
        props.navigation.replace("TodoList");
      } else {
      }
    } catch (e) {
      Alert.alert("Error " + e);
    }
  };

  return (
    <View style={styles.container}>
      <View style={styles.logoContainer}>
        <Image style={styles.logo} source={require("../images/notebook.png")} />
        <Text style={styles.title}>TodoApp Assignment</Text>
      </View>

      <View style={styles.loginInput}>
        <View style={styles.loginContainer}>
          <TextInput
            placeholder="Username"
            onChangeText={(text) => onUsernameChange(text)}
            value={username}
            style={styles.input}
          />
          <TextInput
            placeholder="Password"
            onChangeText={(text) => onPasswordChange(text)}
            value={password}
            secureTextEntry
            style={styles.input}
          />

          <TouchableOpacity style={styles.loginBtn} onPress={onLogin}>
            <Text style={styles.btnText}>LOGIN</Text>
          </TouchableOpacity>
        </View>
      </View>
    </View>
  );
}

export default LoginScreen;
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
  loginBtn: {
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
