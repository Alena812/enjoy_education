const router = require('express').Router();
const con = require('./apiHelper');

router.get("/user", function(req, res) {
    console.log("Get user");

    con.query(`SELECT * FROM users WHERE email = '${req.query.email}'`, function(err, innerRes){
        if(err) {
            throw err;
        }
        if(innerRes.length == 0) {
            console.log("103");
            res.writeHead(103);
            res.end()
            return;
        }
        if(innerRes[0].password != req.query.password) {
            console.log("102");
            res.writeHead(102);
            res.end();
            return;
        }
        console.log("101");
        //res.statusCode = 101;
        //res.write(innerRes[0]);
        res.send(innerRes);
        //res.end();
    });
});

router.post("/user", function(req, res) {
    console.log("Post user");

    con.query(`INSERT INTO users (email, password) VALUES('${req.body.email}', '${req.body.password}')`, function(err){
        if(err) {
            res.sendStatus(500);
            console.log(err);
            return;
        }
        res.send(req.body);
    });
});

module.exports = router;