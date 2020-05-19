const router = require('express').Router();
const con = require('./apiHelper');

router.get("/course", function(req, res) {
    console.log("Get course");
    
    if(req.query.email == '') {
        con.query(`SELECT * FROM courses`, function(err, innerRes){
            if(err) {
                throw err;
            }
            res.send(innerRes);
        });
        return;
    }

    con.query(`SELECT c.id_course, c.title, c.img, c.description, c.email
                FROM courses as c
                INNER JOIN user_course as uc ON uc.id_course = c.id_course
                WHERE uc.email = '${req.query.email}'`, function(err, innerRes){
        if(err) {
            throw err;
        }
        
        res.send(innerRes);
    });
});

router.get("/all_courses", function(req, res) {
    console.log("Get all_courses");
    
    if(req.query.email == '') {
        con.query(`SELECT * FROM courses`, function(err, innerRes){
            if(err) {
                throw err;
            }
            res.send(innerRes);
        });
        return;
    }

    con.query(`SELECT c.id_course, c.title, c.img, c.description, c.email
                FROM courses as c
                INNER JOIN user_course as uc ON uc.id_course = c.id_course
                WHERE uc.email != '${req.query.email}'`, function(err, innerRes){
        if(err) {
            throw err;
        }
        
        res.send(innerRes);
    });
});

module.exports = router;