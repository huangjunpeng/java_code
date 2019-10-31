/*定义请求地址*/
var url = "http://localhost:8080";
url = self.location.protocol + "//" + self.location.hostname;
if (self.location.port!='')
	url = url + ":" + self.location.port;

function isArray(arr) {
	return Object.prototype.toString.call(arr) === "[object Array]";
}
