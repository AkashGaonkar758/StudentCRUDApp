import { useEffect, useState } from "react";
import './form.css'
function Form(){



    const [count, setCount] = useState(0);

    const[name,setName]= useState("");
    const[id,setId]= useState(0);
    const[grade,setGrade]= useState(0);
    const[students,setStudents]=useState([]);


    useEffect(() => {
        fetch('http://localhost:8070/students/getAll')
          .then(res => res.json())
          .then(data => setStudents(data))
          .catch(error => console.error('Error fetching data:', error));
      }, [students]);
    


    

    function onNameChange(e){
        setName(e.target.value)

    }
    function onIdChange(e){
        setId(e.target.value)

    }
    function onGradeChange(e){
        setGrade(e.target.value)

    }

    function Add(e){
        const student={id,name,grade}
        setCount(count+1);
        e.preventDefault()
        fetch("http://localhost:8070/students/add", {
            method: "POST",
            headers: {"Content-Type": "application/json" },
            body: JSON.stringify(student)


        })
    }

    function Update(e){
        const student={id,name,grade}
        setCount(count+1);
        e.preventDefault()
        fetch("http://localhost:8070/students/update", {
            method: "POST",
            headers: {"Content-Type": "application/json" },
            body: JSON.stringify(student)


        })
    }

    function Delete(index){
        
        setCount(count+1);
       
        fetch(`http://localhost:8070/students/remove/${index}`, {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json"
            }})
    }



    return(<>
   
    <h3>Student ID</h3>
    <input type="number" placeholder="Student ID" onChange={(e)=>onIdChange(e)}value={id}/>
    <br></br>
    <h3>Student Name</h3>
    <input type="text" placeholder="Student Name" onChange={(e)=>onNameChange(e)}value={name}/><br/>
    <h3>Student Grade</h3>
    <input type="number" placeholder="Student grade" onChange={(e)=>onGradeChange(e)}value={grade}/><br/>
     
     <button onClick={Add}>Add</button>
     <button onClick={Update}>Update</button>

    


     <ol>

{students.map(student=> (<li key={student.id}> <span> ID: {student.id} &nbsp; 
   Name: {student.name} &nbsp;
   Grade: {student.grade} </span>

   <button onClick={()=>Delete(student.id)}>Delete</button>
  


</li>) )}
</ol>

   
    
    </>
   
       
    );

}

export default Form;