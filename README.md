![GitHub repo size](https://img.shields.io/github/repo-size/Danielvfrodrigues/appbreaktheice?style=for-the-badge)
![GitHub language count](https://img.shields.io/github/languages/count/Danielvfrodrigues/appbreaktheice?style=for-the-badge)

<br>
<br>

<img src="https://github.com/Danielvfrodrigues/appbreaktheice/blob/master/app/src/main/res/drawable/bti_logo_black_png.png" alt="Break The Ice Logo">

> ### Making idle times productive.
<br>
<br>

## 📐 Software Architecture


This project was developed base on the Clean Code Architecture.
Coding the app on Clean provides a plenty of benefits, such as: 

* Easier to maintain;
* Easier to spot bugs;
* Easier to understand;
* Easier for search engines to understand.
<br>


## 💻 Design Pattern


For this application, the Design Pattern of choice was Model–view–viewmodel (MVVM).

The MVVM allows to easily organize the coding files by separating the Graphical User Interface files from the Business Logic files.

### Responsibilities and Characteristics

* ***Model:*** The Model encapsulates the business logic and the data structure of the app.

* ***View:*** The responsibility of the view is to define a appearence or structure presented on screen to the user.

* ***ViewModel:*** The ViewModel responsibility in MVVM's context is to provide a presentation logic to the View by implementing properties and commands so that the View may be able to fill it's controls and notify them.
<br>


## 🧱 SOLID Principles


SOLID is an acronym for the first five object-oriented design (OOD) principles.

#### S - <ins>Single-responsibility Priciple</ins>
* A class should have one and only one job.
#### O - <ins>Open-closed Principle</ins>
* "Objects or entities should be open for extension but closed for modification."
#### L - <ins>Liskov Substitution Principle</ins>
* "Every subclass or derived class should be substitutable for their base or parent class."
#### I - <ins>Interface Segregation Principle</ins>
* A class should not be forced to implement an interface that i doesn't need.
#### D - <ins>Dependency Inversion Principle</ins>
* "Entities must depend on abstractions, not on concretions. It states that the high-level module must not depend on the low-level module, but they should depend on abstractions."
<br>


## 📎 Libraries and Dependencies


#### Database: <ins>Android Room</ins>;
* Used to store important data in cache, so the app may be still functional when the Network is not available.

#### NetWork: <ins>Retrofit</ins>;
* Used to manage the network connection to the API.

#### Dependency Injection: <ins>Koin</ins>;
* "DI is a technique widely used in programming and well suited to Android development. <br>
Implementing dependency injection provides you with the following advantages:
1. Reusability of code;
2. Ease of refactoring;
3. Ease of testing."


#### Async and Reactive Programming: <ins>RX Java</ins>.
* "composing asynchronous streams of real-time data and event-based programs by using observable sequences in a Reactive Programming style. <br>
Benefits of using RxJava:
1. Having responsive applications;
2. Easy Threading and Multi-threading;
3. Solving the problem of Callback Hell;
4. Higher flexibility;
5. Having a mechanism for Error handling;
6. Life-cycle management;
7. Providing an standard workflow for coding;
8. Integration with other libraries."
<br>


## 🌎 Application Map

<img src="https://github.com/Danielvfrodrigues/appbreaktheice/blob/master/app/src/main/res/drawable/break_the_ice_map.png" alt="Break The Ice Map"> 
<br>


## 🔨 Potential Improvements


1. Login Screen;
2. Firebase Authentication with social media profiles;
3. User validation;
<br>

## 💾 Download the App


### Via GitHub:
```
https://github.com/Danielvfrodrigues/appbreaktheice
```
Download the project and run on Android Studio.
<br>
<br>

### Via APK File:
```
https://github.com/Danielvfrodrigues/appbreaktheice/tree/master/Release
```
Download the APK file and install it directly in your device.
<br>
<br>
<br>


## 🚀 How to use Break The Ice


To use Break The Ice app, follow these steps:

Break The Ice is a really simple app. 

1. ***Main Screen***: In the Main Screen, it gives you many options of activities to do in idle time. Beoynd that, you can always apply filters to ease your choice, by clicking the top-right corner menu icon. You just have to ***choose and click***.
2. ***Activity Details Screen***: After you choose and click, the app will show you, in a new screen, ***all the needed information*** of your activity of choice. Other than that, the screen will give you the actions of ***Start and Cancel the activity***.
3. ***Statistics Screen***: This is the last screen of the app. In this one, you can check your activity records and status, such as:

**- Progress Status**:
* In Progress;
* Canceled;
* Done.

**- Time Spent in the activity**.

**- List of activities chosen**.
<br>
<br>
<br>


## 👨‍🚀 Author


This project was developd by

<table>
  <tr>
    <td align="center">
      <a href="https://www.linkedin.com/in/danielvfrodrigues/">
        <img src="https://avatars3.githubusercontent.com/u/78156528" width="100px;" alt="Foto de Daniel Rodrigues no GitHub"/><br>
        <sub>
          <b>Daniel Rodrigues</b>
        </sub>
      </a>
    </td>
  </tr>
</table>
<br>


## 📚 Bibliographic References<br>


***Martin, R. C.(2008)***  <br>
Clean Code: A Handbook of Agile Software Craftsmanship. <br>
https://www.amazon.com.br/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882

***Cadu - DevMedia(2010)*** <br>
Entendendo o Pattern Model View ViewModel MVVM. <br>
https://www.devmedia.com.br/entendendo-o-pattern-model-view-viewmodel-mvvm/18411

***Oloruntoba, S. - Digital Ocean(2020)*** <br>
SOLID: The First 5 Principles of Object Oriented Design. <br>
https://www.digitalocean.com/community/conceptual_articles/s-o-l-i-d-the-first-five-principles-of-object-oriented-design

***Vieira, A. F. V. - Alura*** <br>
Formação Android - Programe na principal plataforma Mobile do mundo. <br>
https://cursos.alura.com.br/formacao-android
