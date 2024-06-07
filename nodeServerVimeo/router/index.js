const express = require("express");
var app = express()
var router = express.Router();
var path = require('path')
var main = require('./main/main') // ./router/main.js
var email = require('./email/email') // ./router/email.js


router.get('/', function (req, res) {
    res.sendFile(path.join(__dirname, "../public/main.html"))
});

router.use('/main', main)
router.use('/email', email)

module.exports = router;