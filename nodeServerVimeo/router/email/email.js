const express = require("express");
var app = express()
var router = express.Router();
var path = require('path')
const mariadb = require("mariadb");

const pool = mariadb.createPool({
    host: 'localhost',
    user:'root',
    password: 'gpgp2932',
    database : 'nodeservervimeodb',
    connectionLimit: 5
});

router.post('/form', function (req, res) {
    console.log(req.body)
    res.render('email.ejs',{'email':req.body.email})
})
router.post('/ajax', function (req, res) {
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

module.exports = router;