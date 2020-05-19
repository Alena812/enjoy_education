  
const express = require("express");
const cors = require('cors')
const fs = require('fs');
const bodyParser = require('body-parser');

const app = express();

app.use(cors());

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));

app.use(require("./api/userApi"));
app.use(require("./api/courseApi"));
app.use(require("./api/lessonApi"));


// app.listen(3000, "127.0.0.1", function(){
//     console.log("Сервер начал прослушивание запросов на порту 3000");
// });

app.listen(3000, "192.168.0.10", function(){
    console.log("Сервер начал прослушивание запросов на порту 3000");
});