import React from 'react'

function Todos({items,removeTodo}) {
    const todos=items;
  
    
    const listTodos=todos.map((item,i)=>{
        return(
            <div className="singleTodo" 
             key={i}>
                 
                <p >No: {i+1}</p>
                <p >Id: {item.id}</p>
                <p>Title: {item.title}</p>
                <p>Date: {new Date(item.date).toLocaleDateString("en-US")} Time: {new Date(item.date).toLocaleTimeString("en-US")}</p>
                <button onClick={()=>removeTodo(item.id)} >Delete</button>
            </div>
        )
    });

    return (
        <div>
            {listTodos}
        </div>
    )
}

export default Todos
