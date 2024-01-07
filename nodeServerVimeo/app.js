var express = require('express')
var app = express()
var bodyParser = require('body-parser')
var mariadb = require('mariadb');

const pool = mariadb.createPool({
	host: 'localhost',
	user:'root',
	password: 'gpgp2932',
	database : 'nodeservervimeodb',
	connectionLimit: 5
});


app.listen(3000, function(){
		console.log("start server...");
});

app.use(express.static('public'))
app.use(bodyParser.json())
app.use(bodyParser.urlencoded({extended: true}))
app.set('view engine', 'ejs')

app.get('/', function (req, res) {
	res.sendFile(__dirname + "/public/main.html")
})


app.get('/main', function (req, res) {
	res.sendFile(__dirname + "/public/main.html")
})

app.post('/email-post', function (req, res) {
	console.log(req.body)
	res.render('email.ejs',{'email':req.body.email})
})
app.post('/ajax-send-email', function (req, res) {
	var reqEmail = req.body.email;
	var responseData = {};

	var findEmailQuery= pool.getConnection()
						.then(conn => {
							conn.query("SELECT * FROM USERS WHERE EMAIL = ? LIMIT 1", [reqEmail])
								.then((rows) => {
									if(rows.length > 0){
										responseData.code = 200;
										responseData.result = "ok";
										responseData.data = rows[0]
									}else{
										responseData.code = 404;
										responseData.result = "error";
										responseData.message = "등록 되지 않은 이메일 입니다. 회원가입을 해주세요";
									}
									conn.end();
									res.json(responseData);

								})
								.catch(err => {
									conn.end();
									throw err;
								})
						})
						.catch(err => {
							throw err;
						})

})