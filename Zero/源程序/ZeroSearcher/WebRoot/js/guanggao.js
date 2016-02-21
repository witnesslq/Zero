// JavaScript Document


var oPopup = window.createPopup();
var popTop=50;
function popmsg(msgstr){
var winstr="<table width=\"241\" height=\"172\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\"  background=\"images/guanggao.jpg\" >";
winstr+="<tr><td height=\"30\"> </td></tr><tr><td align=\"center\"><table width=\"90%\" height=\"110\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">";
winstr+="<tr><td valign=\"top\" style=\"font-size:12px;\">"+msgstr+"</td></tr></table></td></tr></table>";
oPopup.document.body.innerHTML = winstr;
popshow();
}
function popshow(){
window.status=popTop;
if(popTop>1720){
clearTimeout(mytime);
oPopup.hide();
return;
}else if(popTop>1520&&popTop<1720){
oPopup.show(screen.width-250,screen.height,241,1720-popTop);
}else if(popTop>1500&&popTop<1520){
oPopup.show(screen.width-250,screen.height+(popTop-1720),241,172);
}else if(popTop<180){
oPopup.show(screen.width-250,screen.height,241,popTop);
}else if(popTop<220){
oPopup.show(screen.width-250,screen.height-popTop,241,172);
}
popTop+=10;
var mytime=setTimeout("popshow();",50);
}