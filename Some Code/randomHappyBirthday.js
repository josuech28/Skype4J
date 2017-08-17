const options = {
	"listOptions": [
		{
			"option": "Feliz cumpleaños"
		},
		{
			"option": "Alles gute zum Geburstag"
		},
		{
			"option": "Jouyeux anniversaire"
		},
		{
			"option": "Happy birthday"
		},
		{
			"option": "Sun Yat Fai Lok"
		},
		{
			"option": "Buon Compleanno"
		}
	]
}

function getOption() {
	return options.listOptions[Math.floor(Math.random() * options.listOptions.length)];
}

function getHappyBirthday(){
	console.log('Josue wish you  ' + getOption().option);
}

getHappyBirthday();