function saveStock() {
    let selectedStock = document.getElementById('stock-list').value;
    let savedStockList = document.getElementById('saved-stock-list');

    if (selectedStock === '관심종목 추가') {
        alert('관심 종목을 선택해주세요.');
    } else {
        let opt = document.createElement('option');
        opt.value = selectedStock;
        opt.text = selectedStock;
        savedStockList.appendChild(opt);
    }
}
