var http  = require('http')
var helloword  = "hellowora中国啊d";
helloword = new Buffer(helloword);
http.createServer(function(req,res){
	console.log("aaa----");
   var aa = ''
	req.on('data',function(chunk){
		aa+=chunk;

	});
	req.on('end',function(){
		console.log("end----"+aa);
		res.writeHead(200,{'Content-Type':'application/octet-stream'});
	    res.end(helloword)
	})
	
	
}).listen(8001);


