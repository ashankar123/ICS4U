function removeRunner(row) {
	//make if statement for ensuring the user actually wants to delete a runner
	if (confirm("Are you sure you want to delete this Runner? This cannot be reversed.")) {
		//deleting row, then updating row indexes of each runner, so the button deletes it's assigned row
		var x = row.parentNode.parentNode.rowIndex;
		document.getElementById("runnerData").deleteRow(x);
		var numberOfRows = document.getElementById("runnerData").rows.length;
	}
	//to make sure user never deletes all runners...
	if (numberOfRows == 0) {
		alert("You need at least one runner!");
		addRunner();
	}
}

runnerNum = 6;

function addRunner() {
	var table = document.getElementById("runnerData");
	var row = table.insertRow(-1);
	//from HTML, the tr id makes for the runners to be called by their row id
	row.id = runnerNum;
	//creating new row
	var removeRunner = row.insertCell(0);
	var name = row.insertCell(1);
	var mileOne = row.insertCell(2);
	var mileTwo = row.insertCell(3);
	var splitTwo = row.insertCell(4);
	var splitThree = row.insertCell(5);
	var totalTime = row.insertCell(6);
	//for cells in added rows, adding placeholders, events, identifiers, types.
	removeRunner.innerHTML = '<input name="remove" class="remove" onclick="removeRunner(this)" type="button" value="X">';
	name.innerHTML = '<input placeholder=" name here" type="text" onblur="checkFormat(' + runnerNum + ')">';
	mileOne.innerHTML = '<input placeholder="mm:ss.sss" type="text" onblur="checkFormat(' + runnerNum + ')" id="mileOne' + runnerNum + '">';
	mileTwo.innerHTML = '<input placeholder="mm:ss.sss" type="text" onblur="checkFormat(' + runnerNum + ')" id="mileTwo' + runnerNum + '">';
	splitTwo.innerHTML = '<input type="text" id="splitTwo' + runnerNum + '" disabled>';
	splitThree.innerHTML = '<input type="text" id="splitThree' + runnerNum + '"  disabled>';
	totalTime.innerHTML = '<input placeholder="mm:ss.sss" type="text" onblur="checkFormat(' + runnerNum + ')" id="totalTime' + runnerNum + '">';
	//add to number of runners; keeps other methods consistent with the added runner
	runnerNum++;
}

function diffTime(runnerNum) {
	var table = document.getElementById('runnerData');
	const SECONDS = 60;
	//getting raw values from table
	var mileOneTime = document.getElementById("mileOne" + runnerNum).value;
	var mileTwoTime = document.getElementById("mileTwo" + runnerNum).value;
	var totalTime = document.getElementById("totalTime" + runnerNum).value;
	//splitting input string into minutes, seconds, and total seconds
	var mileOneMin = parseInt(mileOneTime.split(":")[0]);
	var mileOneSec = parseFloat(mileOneTime.split(":")[1]);
	var mileOneTotal = SECONDS * mileOneMin + mileOneSec;
	var mileTwoMin = parseInt(mileTwoTime.split(":")[0]);
	var mileTwoSec = parseFloat(mileTwoTime.split(":")[1]);
	var mileTwoTotal = SECONDS * mileTwoMin + mileTwoSec;
	var totalTimeMin = parseInt(totalTime.split(":")[0]);
	var totalTimeSec = parseFloat(totalTime.split(":")[1]);
	var totalTimeTotal = SECONDS * totalTimeMin + totalTimeSec;
	//calculate split times
	var SplitTwo = mileTwoTotal - mileOneTotal;
	var SplitTwoSec = SplitTwo % SECONDS;
	var SplitThree = totalTimeTotal - mileTwoTotal;
	var SplitThreeSec = SplitThree % SECONDS;
	//outputting split values back into cells, in proper mm:ss.sss format
	var returnSplitTwo = (parseInt(SplitTwo / SECONDS) + ":" + SplitTwoSec.toFixed(3));
	var returnSplitThree = (parseInt(SplitThree / SECONDS) + ":" + SplitThreeSec.toFixed(3));
	var tableSplitTwo = document.querySelector("#splitTwo" + runnerNum);
	tableSplitTwo.value = returnSplitTwo;
	var tableSplitThree = document.querySelector("#splitThree" + runnerNum);
	tableSplitThree.value = returnSplitThree;
}

function checkFormat(runnerNum) { 
	var table = document.getElementById('runnerData');
	//checks if cell is empty
	var emptyCheck = /^\s*$/;
	//regex checks the proper format for time input
	var checkFormat = /^([0-5][0-9]|[0-9]):([0-5][0-9])(:|\.)\d{3}$/;
	//setting vars for getting inputted values from table
	var timeOne = document.getElementById("mileOne" + runnerNum).value;
	var timeTwo = document.getElementById("mileTwo" + runnerNum).value;
	var timeTotal = document.getElementById("totalTime" + runnerNum).value;

	//checking for correct format, set false -> return true if formatted
	var firstTime = false;
	var secondTime = false;
	var totalTime = false;
	//if time inputted is wrong format, return true
	var incorrect = false;

	//for incorrect format + unempty
    if (!emptyCheck.test(timeOne) && !checkFormat.test(timeOne)) { 
        error = true;
    } else if (!emptyCheck.test(timeOne) && checkFormat.test(timeOne)) { 
        firstTime = true;
        error = false;
    }
    if (!emptyCheck.test(timeTwo) && !checkFormat.test(timeTwo)) {
        error = true;  
    } else if (!emptyCheck.test(timeTwo) && checkFormat.test(timeTwo)) {
        secondTime = true;
        error = false;
    }
    if (!emptyCheck.test(timeTotal) && !checkFormat.test(timeTotal)) { 
        error = true;  
    } else if (!emptyCheck.test(timeTotal) && checkFormat.test(timeTotal)) { 
        totalTime = true;
        error = false;
    }
    
    //alert user to the formatting error
    if (error) { 
        alert("Wrong Format! (mm:ss.sss)");
    }
	
	//if all formats are approved, calculate diffTime on the runner    
    if (firstTime && secondTime && totalTime) { 
        diffTime(runnerNum);
    }
}