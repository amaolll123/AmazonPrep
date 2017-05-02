const express = require('express');
const router = express.Router();
const passport = require('passport');
const jwt = require('jsonwebtoken');



const User = require('../models/user')

//已经在app.js 中定义了'/users'
//localhost:3000/users/register
router.post('/register',(req,res,next)=>{
 
    let newUser = new User({
  	
    name: req.body.name,
    email: req.body.email,
    username: req.body.username,
    password: req.body.password
     });

    User.addUser(newUser,(err,user)=>{
        if(err){
            res.json({success:false,msg:"fail to add a user"});
        }else{
            res.json({success:true,msg:"User Registered!"});
        }
    })
    
});

router.post('/register', (req, res, next) => {
  res.send("hello");
});
router.post('/authentication',(req,res,next)=>{
    res.send("Authentication page");
});
router.get('/profile',(req,res,next)=>{
    res.send("Profile page");
});



//留给require用的
module.exports = router;