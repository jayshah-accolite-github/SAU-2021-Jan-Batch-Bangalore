import React,{useState,useEffect} from 'react'

function TodoInput(props) {
    const[title,setTitle]=useState("");
    const[dateTime,setDateTime]=useState("");
    const onHandleTitleChange=(event)=>{
        setTitle(event.target.value);
    }
    const onHandleDateChange=(event)=>{
        setDateTime(event.target.value);
    }
    const onSubmitTodo=(event)=>{
        event.preventDefault();
       
        props.onSubmit({
            title:title,
            date:dateTime,

        });

        setTitle("");
        setDateTime("");
    }

    return (
        <div className="main-form">
        <form className="todo-form" onSubmit={onSubmitTodo}>
            <div className="todo-form-title">
                <h3>Todo Title:</h3>
            <input type="text" 
                    placeholder="Type Something...."
                    value={title} 
                    onChange={onHandleTitleChange}
                    >
            </input>
            </div>
            <br></br>
            <div  className="todo-form-date">
            <h3>Todo Completion Date:</h3>
            <input type="datetime-local" 
                    value={dateTime} 
                    onChange={onHandleDateChange}
                    >
            </input>
            </div>
            <br></br>
            <button className="todo-form-add" onClick={onSubmitTodo}>Add</button>
        </form>
        </div>
    )
}

export default TodoInput
