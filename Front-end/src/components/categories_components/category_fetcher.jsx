import { useEffect ,useState } from "react";
import { getCategories } from "../../sites";





 const url = getCategories;


function DateAndName(category){
  const DateAndNames = category.map((data) => {
     const newObject = { categorie: data.name };
     return newObject;
  });
  return DateAndNames;
}

 
 export function Categories(){
 

const [category, setcategory] = useState([]);
useEffect(() => {
   fetch(url)
    .then((res) => res.json())
    .then((data) => {
      setcategory(DateAndName(data.allCategories));
    });
}, []);
return category
};



  


