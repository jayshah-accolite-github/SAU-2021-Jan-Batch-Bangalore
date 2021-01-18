import React,{useState} from 'react'
import TodoInput from '../TodoInput/TodoInput'
import Todos from '../Todos/Todos';

function TodoList() {

const [todoList, setTodoList] = useState([{id:1,title:"finish react project",date:new Date(2021,1,3)}
,{id:2,title:"finish react project",date:new Date(2021,1,2)}]);
    let id=3;
    const removeTodo=(id)=>{
        const removeArr=[...todoList].filter(item=>item.id!==id);
        setTodoList(removeArr);
    
    }
    const onTodoReceived=(props)=>{
        props.id=id++;

        if(props.title === ""||props.date ==="")
    {
        
        alert("please give all fields");
    
    }else{
        
        const newList=[props,...todoList];
         newList.sort(function(a,b){ 
            return new Date(a.date).getTime() - new Date(b.date).getTime();
           });
        setTodoList(newList);
    }
    }

    return (
        <div className="main-singleTodo">
            <div className="todoInput">
        
            <TodoInput onSubmit={onTodoReceived} />
            </div>
            <div className="todo-list">
                <h3>List Of Todos Sorted By Completion Date (Ascending)</h3>
            <Todos items={todoList} removeTodo={removeTodo} />
            </div>
        </div>
    )
}

export default TodoList
