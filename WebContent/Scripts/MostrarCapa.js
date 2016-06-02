function showdiv(event,text){
	margin=5;
	//La variable IE determina si estamos utilizando IE
	var IE = document.all?true:false;
	var tempX = 0;
	var tempY = 0;
	//document.body.clientHeight = devuelve la altura del body
	if(IE){ //para IE
		IE6=navigator.userAgent.toLowerCase().indexOf('msie 6');
		IE7=navigator.userAgent.toLowerCase().indexOf('msie 7');
		//event.y|event.clientY = devuelve la posicion en relacion a la parte superior visible del navegador
		//event.screenY = devuelve la posicion del cursor en relaciona la parte superior de la pantalla
		//event.offsetY = devuelve la posicion del mouse en relacion a la posicion superior de la caja donde se ha pulsado
		if(IE6>0 || IE7>0)
		{
			tempX = event.x
			tempY = event.y
			if(window.pageYOffset){
				tempY=(tempY+window.pageYOffset);
				tempX=(tempX+window.pageXOffset);
			}else{
				tempY=(tempY+Math.max(document.body.scrollTop,document.documentElement.scrollTop));
				tempX=(tempX+Math.max(document.body.scrollLeft,document.documentElement.scrollLeft));
			}
		}else{
			//IE8
			tempX = event.x
			tempY = event.y
		}
	}else{ //para netscape
		//window.pageYOffset = devuelve el tamaño en pixels de la parte superior no visible (scroll) de la pagina
		document.captureEvents(Event.MOUSEMOVE);
		tempX = event.pageX;
		tempY = event.pageY;
	}
	if (tempX < 0){tempX = 0;}
	if (tempY < 0){tempY = 0;} 
	var img = "<img src='" + text + "'/>";
	document.getElementById('flotante').innerHTML=img;
	document.getElementById('flotante').style.top = (tempY+margin)+"px";
	document.getElementById('flotante').style.left = (tempX+margin)+"px";
	document.getElementById('flotante').style.display='block';
	return;
}
function hiddenDiv(){
	document.getElementById('flotante').style.display='none';
}