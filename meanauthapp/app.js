//导入所有Module
const express = require('express');
const path = require('path');//属于cors
const bodyParser = require('body-parser');
const cors = require('cors');
const passport = require('passport');
const mongoose = require('mongoose');
const config = require('./config/database');

//mongoDB 连接
mongoose.connect(config.database);

mongoose.connection.on("connected",()=>{
    console.log("Connected to Database: "+ config.database);
})
mongoose.connection.on("error",(err)=>{
    console.log("Connected to Database: "+ err);
})

//把route信息放在一起
const users = require('./routes/users.js');

//用express框架？
const app = express();

// Port Number
const port = 3000;


// CORS Middleware 从不同域名给api发要求？不太懂
//让网站公开，所有域名access, disable 其中一些
app.use(cors());


//localhost:3000/users/xxx 会指引到那个文件夹
app.use('/users',users);

//从form中拿数据？不太懂
app.use(bodyParser.json());



//set Static page
//为啥设置完了直接就成了首页？
app.use(express.static(path.join(__dirname,'public')));

//Index Route
app.get('/',(req,res)=>{
    res.send('Invalid End Point!');
});


//Start Server
app.listen(port,()=>{//function是后面的表达式
    console.log('Server started in port  '+port);
})