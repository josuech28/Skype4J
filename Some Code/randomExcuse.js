const options = {
	"listOptions": [
		{
			"option": "honey"
		},
		{
			"option": "bae"
		},
		{
			"option": "baby"
		},
		{
			"option": "love"
		},
		{
			"option": "sweetheart"
		}
	]
}

function getOption() {
	return options.listOptions[Math.floor(Math.random() * options.listOptions.length)];
}

function getText(){
	console.log('I promise ' + getOption().option);
}

getText();