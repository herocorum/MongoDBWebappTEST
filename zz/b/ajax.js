var xmlHttp = null;
var pddtemp = null;
var ddtemp = null;
var ddDiv = null;
var tempDiv = document.getElementById("temp_div");
var count = 1;

function getXmlHttpObj()
{
	if(window.XMLHttpRequest)
	{
		xmlHttp = new XMLHttpRequest();
	}
	else
	{
		xmlHttp = new ActiveXobject("Microsoft.XMLHTTP");
	}
	return xmlHttp;
}
function addRowDiv()
{
	count++;
	var tempId = count;
	var url = "addRow.jsp";
	var pDiv = document.getElementById("parentDiv");
	var newDiv = document.createElement("div");
	pDiv.appendChild(newDiv);
	var divId = "div_"+tempId;
	newDiv.setAttribute("id", divId);
	xmlHttp = getXmlHttpObj();
	url += "?tempId="+tempId;
	xmlHttp.onreadystatechange=stateChanged;
	xmlHttp.open("GET",url,truexmlHttxmlHttp.send(null));
	showhideAddLink();
	showhideDeleteLink();
}
function stateChanged()
{
	if(xmlHttp.readyState == 4 || xmlHttp.readyState == "complete")
	{
		var newDivId = "div_"+count;
		document.getElementById(newDivId).innerHTML = xmlHttp.responseText;
	}
}
function removeRowDiv(divNum)
{
	var tempId = count;
	var pDiv = document.getElementById("parentDiv");
	var divId = "div_"+tempId;
	var delDiv = document.getElementById(divId);
	pDiv.removeChild(delDiv);
	count--;
	showhideAddLink();
	showhideDeleteLink();
}

function showhideAddLink()
{
	if(count < 10)
	{
	document.getElementById("addLink").style.display = 'block';
        }
        else
        {
	document.getElementById("addLink").style.display = 'none';
	}
}

function showhideDeleteLink()
{
	if(count > 1)
	{
	document.getElementById("delLink").style.display = 'block';
        }
        else
        {
	document.getElementById("delLink").style.display = 'none';
	}
}