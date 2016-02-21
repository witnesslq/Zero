﻿// JavaScript Document
    
 var Swidth = parseInt(window.screen.availWidth)/2-9;
 
function id(obj){
 return document.getElementById(obj);
}
var page;
var lm,mx;
var md=false;
var sh=0;
var en=false;
window.onload=function(){
 page=document.getElementsByTagName("div");
 if(page.length>0){
  page[0].style.zIndex=2;
 }
 for(i=0;i<page.length;i++){
  page[i].className="page";
  page[i].innerHTML+="<span class=tip>第 "+(i+1)+"/"+page.length+" 页 提示：左右拖拽翻页</span>";
  page[i].id="page"+i;
  page[i].i=i;
  page[i].onmousedown=function(e){
   if(!en){
    if(!e){e=e||window.event;}
    lm=this.offsetLeft;
    mx=(e.pageX)?e.pageX:e.x;
    this.style.cursor="w-resize";
    md=true;
    if(document.all){
     this.setCapture();
    }else{
     window.captureEvents(Event.MOUSEMOVE|Event.MOUSEUP);
    }
   }
  }
  page[i].onmousemove=function(e){
   if(md){
    en=true;
    if(!e){e=e||window.event;}
    var ex=(e.pageX)?e.pageX:e.x;
    this.style.left=ex-(mx-lm)+350;
    
    
    
    
    if(this.offsetLeft<(Swidth-350)){
     var cu=(this.i==0)?page.length-1:this.i-1;
     page[sh].style.zIndex=0;
     page[cu].style.zIndex=1;
     this.style.zIndex=2;
     sh=cu;
    }
    if(this.offsetLeft>(Swidth-350)){
     var cu=(this.i==page.length-1)?0:this.i+1;
     page[sh].style.zIndex=0;
     page[cu].style.zIndex=1;
     this.style.zIndex=2;
     sh=cu;
    }
    
   
   }
  }
  page[i].onmouseup=function(){
   this.style.cursor="default";
   md=false;
   if(document.all){
    this.releaseCapture();
   }else{
    window.releaseEvents(Event.MOUSEMOVE|Event.MOUSEUP);
   }
   flyout(this);
  }
 }
}
function flyout(obj){
 if(obj.offsetLeft<(Swidth-350)){
  if(  (obj.offsetLeft + 350 - 20) > (Swidth-700) ){
   obj.style.left=obj.offsetLeft + 350 - 20;
   window.setTimeout("flyout(id('"+obj.id+"'));",0);
  }else{
   obj.style.left=(Swidth-700);
   obj.style.zIndex=0;
   flyin(id(obj.id));
  }
 }
 if(obj.offsetLeft>(Swidth-350)){
  if(  (obj.offsetLeft + 350 + 20) < (Swidth+700) ){
   obj.style.left=obj.offsetLeft + 350 + 20;
   window.setTimeout("flyout(id('"+obj.id+"'));",0);
  }else{
   obj.style.left=(Swidth+700);
   obj.style.zIndex=0;
   flyin(id(obj.id));
  }
 }
}
function flyin(obj){
 if(obj.offsetLeft<(Swidth-350)){
  if(  (obj.offsetLeft + 350 + 20) < Swidth  ){
   obj.style.left=obj.offsetLeft + 350 + 20;
   window.setTimeout("flyin(id('"+obj.id+"'));",0);
  }else{
   obj.style.left=Swidth;
   en=false;
  }
 }
 if(obj.offsetLeft>(Swidth-350)){
  if(  (obj.offsetLeft + 350 - 20) > Swidth  ){
   obj.style.left=obj.offsetLeft + 350 - 20;
   window.setTimeout("flyin(id('"+obj.id+"'));",0);
  }else{
   obj.style.left=Swidth;
   en=false;
  }
 }
}