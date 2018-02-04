<!DOCTYPE html>
<html>
<style>
body  {
    background-image: url("12.jpg");
}
</style>
<body>
<div id="player"></div>
<bgsound src="main.mp3">
	
<script>

var tag=document.createElement('script');
tag.src="https://www.youtube.com/iframe_api";
var firstScriptTag=document.getElementsByTagName('script')[0];
firstScriptTag.parentNode.insertBefore(tag,firstScriptTag);
`	
var player,vt,v,data;
function onYouTubeIframeAPIReady()
{
player=new YT.Player('player',{
height:'330',
width:'440',
events:{
'onReady' :null,
}
})
}

function playVid()
{
player.playVideo();
};
function pauseVid()
{
player.pauseVideo();
};
function muteVid()
{
player.mute();
};
function unMuteVid()
{
player.unMute();
};
function stopVid()
{
player.stopVideo();
document.write(data.value);
};
function seekTo(seconds)
{
player.seekTo(document.getElementById('seekto').value);
};
function newfun(text)
{
	player.stopVideo();
};

function loadVid()
{
	player.loadVideoById(document.getElementById('editor').value);
};

function currenttime() {
	//v=document.createElement('p');
    data=document.getElementById('ta');
    data.value =data.value+'\n'+player.getCurrentTime()+": "+document.getElementById('in').value;
    
};
</script>
<br>
<a href="javascript:void(0):" onclick="loadVid();">load</a>
||
<a href="javascript:void(0):" onclick="playVid();">play</a>
||
<a href="javascript:void(0):" onclick="stopVid();">stop</a>
||
<a href="javascript:void(0):" onclick="pauseVid();">pause</a>
||
<a href="javascript:void(0):" onclick="muteVid();">mute</a>
||
<a href="javascript:void(0):" onclick="unMuteVid();">unmute</a>
||
<a href="javascript:void(0):" onclick="seekTo();">seekto</a>
||
<a href="javascript:void(0):" onclick="currenttime();">curtime</a>
||

<br>
<form action="serv1" method="post">
paste the videoid:<input type="text" id="editor" name="vid"/>
seek to:<input type="text" id="seekto"/>
<div align="right">
point to be noted:<input type="text" id="in">
<br/>

<textarea rows="4" cols="50" id="ta" name="tarea"></textarea>
<input type="submit" value="submit">
</div>
</form>
</body>
</html>