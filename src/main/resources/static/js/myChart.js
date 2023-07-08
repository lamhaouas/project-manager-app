var chartDataStr = decodeHtml(chartData);
var chartJsonArray = JSON.parse(chartDataStr);

var arrayLength =  chartJsonArray.length;
var numericData = [];
var labelData = [];

for (var i=0; i < arrayLength; i++){
    numericData[i] = chartJsonArray[i].val;
    labelData[i]= chartJsonArray[i].label;
}
//For a pie chart
new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    data: {
        labels: labelData,
        datasets:[{
            label: 'My data set',
            backgroundColor:["#f72585","#7209b7","#b5179e"],
            data: numericData
        }]
    },
    options :{
        title: {
            display: true,
            text: 'Project Status'}
    }
});

function decodeHtml(html){
    var text = document.createElement("textarea");
    text.innerHTML = html;
    return text.value;
}
