function updateText() {
	alert("dwedwe");
    var words = 'Hi, I am Siyun a recent Computer Science graduate.';
    document.getElementById("word").innerHTML = words;
    document.getElementById("word").innerHTML.style.color = "blue";
}


function wait() {
	
}

function loadText() {
	var text= "Hi, I am Siyun, a recent Computer Science graduate.";
	var delay= 100;
	var elem = $("#myText");
	var reverse = false;
	var i = 0;
	//text- string
	//elem - jQuery element where text is to be attached
	//delay - the delay in each text
	var addTextByDelay = function(text,elem,delay){


	    if(!elem){
	        elem = $("body");
	    }
	    if(!delay){
	        delay = 200;
	    }
	    
	    if (text.length == 0){
	    	if (reverse) {reverse = false;}
	    	else {reverse = true;}
	    	elem.empty();
	    	text = "Hi, I am Siyun, a recent Computer Science graduate.";
	 
	    }
//	    
	    if (reverse == true) {
		    if(text.length > 0){
		        //append first character 
		    	elem.empty();
		        elem.append(text);
		        setTimeout(
		            function(){
		                //Slice text by 1 character and call function again                
		                addTextByDelay(text.slice(0, text.length - 1),elem,delay);            
		             },delay                 
		            );
		    }
	    }
	    if (reverse == false) {
		    if(text.length > 0){
		        //append first character 
		        elem.append(text[0]);
		        setTimeout(
		            function(){
		                //Slice text by 1 character and call function again                
		                addTextByDelay(text.slice(1),elem,delay);            
		             },delay                 
		            );
		    }
	    }

	    

	}

	document.getElementById("home").style.visibility = "visible";
	addTextByDelay(text,elem,delay);
	
}



