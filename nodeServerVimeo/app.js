var express = require('express')
var app = express()
var bodyParser = require('body-parser');
var router = require('./router/index') // ./router/index.js


app.listen(3000, function(){
		console.log("start server...");
});

app.use(express.static('public'))
app.use(bodyParser.json())
app.use(bodyParser.urlencoded({extended: true}))

app.set('view engine', 'ejs')


app.use('/', router)





