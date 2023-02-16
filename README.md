<div align="center">
    <h1>SOLID: The First 5 Principles of Object-Oriented Design</h1>
    <p align="center">
        Applying SOLID principles in order to make the code more readable, reusable, and maintainable.
    </p>
</div>
<details>
  <summary>SOLID Principles:</summary>
    <ol>
        <li>
            <a href="#OCP">OCP</a></li>
        <li>
            <a href="#ISP">ISP</a>
        </li>
        <li>
            <a href="#SRP">SRP</a>
        </li>
        <li>
            <a href="#LSP">LSP</a>
        </li>
        <li>
            <a href="#DIP">DIP</a>
        </li>
    </ol>
</details>


# OCP 
### Before Applying the Open-Closed Principle
#### UML Diagram:
![before_OCP](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/Azer-ch/Software-Architecture/main/OCP/src/com/directi/training/ocp/exercise/before_OCP.puml) 
#### Problem:
Upon closer inspection of the ResourceAllocator class we notice that both the allocate() and free() methods are tightly coupled to the Resource type. This means that adding a new type of Resource will require changes to the ResourceAllocator class. This is a violation of the Open-Closed Principle. The ResourceAllocator class should be open for extension but closed for modification.
##### Allocate function Code snippet:
![allocate_method_code](screenshots/1.svg)
### After Applying the Open-Closed Principle
#### UML Diagram:
![after_OCP](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/Azer-ch/Software-Architecture/main/OCP/src/com/directi/training/ocp/exercise_refactored/after_OCP.puml)
#### Solution:
Instead of having the ResourceAllocator class explicitly defining how to allocate and free resources we created an interface that declares the signature of said methods and upon creating new Resources such as Space and Time, we simply implement the interface and override the methods. This way, the ResourceAllocator class is not affected by the changes made to the Resource class.
##### Resource Allocator Class:
![resource_allocator_class](screenshots/2.svg)
# ISP
### Before Applying the Interface Segregation Principle
#### UML Diagram:
![before_ISP](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/Azer-ch/Software-Architecture/main/ISP/src/com/directi/training/isp/exercise/before_ISP.puml)
#### Problem:
Different types of doors behave differently. For example, a sensing door opens or closes based on the presence of an object in its proximity.A timed door opens or closes based on the time period specified.Thus it doesn't make sense to dump all the door related functionality into a single interface.The sensingDoor class has to implement the timeOutCallback() method which is not required for it to function. This is a violation of the Interface Segregation Principle that states that a client should never be forced to implement an interface that it doesn't use.
### After Applying the Interface Segregation Principle
#### UML Diagram:
![after_ISP](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/Azer-ch/Software-Architecture/main/ISP/src/com/directi/training/isp/exercise_refactored/after_ISP.puml)
#### Solution:
The better approach is to create separate interfaces for each type of door.Thus each specific type of door will handle functionalities that are relevant to it.In our example,two new interfaces emerge that inherit the Door interface:
##### IProximityDoor:
![proximity_door_interface](screenshots/3.svg)
##### ITimeOutDoor:
![timeout_door_interface](screenshots/4.svg)

And now the Sensor and Timer Clients use specifically what they have to use.(the proximityCallback() and the timeOutCallback() methods respectively from the IProximityDoor and ITimeOutDoor interfaces)
##### Sensor Client:
![sensor_client](screenshots/5.svg)
# SRP
### Before Applying the Single-responsibility Principle
#### UML Diagram:
![before_SRP](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/Azer-ch/Software-Architecture/main/SRP/src/com/directi/training/srp/exercise/before_SRP.puml)
#### Problem:
Upon a quick glimpse at the CarManager class,we'd be able to tell that it has a lot on its plate.It has multiple responsibilities such as:

1- Creating the Cars

2- Retrieving a specific car by Id

3- Getting the names of all the cars

4- Picking out the best car by the newest model

This clearly violates the Single-responsibility Principle that states that a class should only have one reason to change,meaning that a class should have only one job..
### After Applying the Single-responsibility Principle
#### UML Diagram:
![after_SRP](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/Azer-ch/Software-Architecture/main/SRP/src/com/directi/training/srp/exercise_refactored/after_SRP.puml)
#### Solution:
In order to make our code easily maintainable and scalable,We split the CarManager class into three separate classes:

1- CarRepository : handles the fetching of cars from the database.

2- CarCatalogue : creates the catalogue containing the cars' names in our shop.

3- CarComparator : Picks out the best car by the newest model.

# LSP
### Before Applying the Liskov Substitution Principle
#### UML Diagram:
![before_LSP](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/Azer-ch/Software-Architecture/main/LSP/src/com/directi/training/lsp/exercise/before_LSP.puml)
#### Problem:
In the Pool class upcasting (Duck electricDuck = new ElectronicDuck()) generates an error since we assume that an Electronic duck can swim and quack without any prior actions which is the not the case since we have to turn it on before.Thus making the substitution of the ElectronicDuck with a Duck invalid which violates the Liskov Substitution Principle that states that objects of a superclass shall be replaceable with objects of its subclasses without breaking the application.
### After Applying the Liskov Substitution Principle
#### UML Diagram:
![after_LSP](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/Azer-ch/Software-Architecture/main/LSP/src/com/directi/training/lsp/exercise_refactored/after_LSP.puml)
#### Solution:
Two methods were added to the base class that make sure that a duck can truly swim or quack.
###### Duck Class:
![duck_class](screenshots/6.svg)

The electronic duck then overrides these methods:
##### Electronic Duck Class:
![electronic_duck_class](screenshots/7.svg)

Now a simple check on weather a duck can swim or quack is enough to make sure that the substitution is valid.

##### Quack Method of the Pool Class:
![quack_method](screenshots/8.svg)

# DIP
### Before Applying the Dependency Inversion Principle
#### UML Diagram:
![before_DIP](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/Azer-ch/Software-Architecture/main/DIP/src/com/directi/training/dip/exercise/before_DIP.puml)
#### Problem:
### After Applying the Dependency Inversion Principle
#### UML Diagram:
![after_DIP](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/Azer-ch/Software-Architecture/main/DIP/src/com/directi/training/dip/exercise_refactored/after_DIP.puml)

The Encoding Module depends on the concrete class MyDatabase meaning that each modification in the MyDatabase class will require a change in the Encoding Module.More precisely the Encoding Module is explicitly instantiating the MyDatabase by calling its constructor,this means that adding new attributes to the database class will trigger a change in the way its constructor is called and thus a modification in the Encoding Module.This violates the Dependency Inversion Principle that states that high-level modules should not depend on low-level modules,both should depend on abstractions.
#### Solution:
Creating an interface for the Database class and making the Encoding Module depend on it instead of the concrete class MyDatabase and having its constructor take a MyDatabase instance will make the high level module depend on abstractions instead.
##### My Database Class:
![my_database_class](screenshots/9.svg)

We also adopted the singleton design patter to make sure that only one instance of the database is created.

##### Encoding Module Class:
![encoding_module_class](screenshots/10.svg)

We pass in the database as a parameter to the constructor instead of explicitly instantiating it.

