
import './App.css';
import TodoInput from './components/TodoInput/TodoInput';
import TodoList from './components/TodoList/TodoList';
import React from 'react';

class App extends React.Component {
 render(){
  return (
  <div className="main">
 <div className="heading">
  <h1>Todo App Assignment</h1>
  </div>
  <div className="content">
  <TodoList/>
  </div>
  </div>
  );
}}

export default App;
