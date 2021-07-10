function stockList(csv) {

    let lines = csv.split("\n");
    let result = [];

    let headers = lines[0].split(",");

    for (var i = 1; i < lines.length; i++) {
        var obj = {};
        var line = lines[i].split(",");

        for (var j = 0; j < headers.length; j++) {
            obj[headers[j]] = line[j];
        }

        result.push(obj);
    }

    return JSON.stringify(result);
}