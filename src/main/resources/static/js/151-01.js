/*
Copyright by Audi 2006
http://audi.tw
http://www.carousel.com.tw
歡迎應用於無償用途散播，並請勿移除本版權宣告

*/

function loadAddress(form){
	document.write('<select name="city" onChange="cityOnChange(this.form.city,this.form.town);this.form.cityVal.value=this.form.city.options[this.form.city.selectedIndex].text;this.form.townVal.value=this.form.town.options[this.form.town.selectedIndex].text;">');
	document.write('<option selected>台北市</option><option>新北市</option><option>基隆市</option><option>宜蘭縣</option><option>桃園市</option><option>新竹市</option><option>苗栗縣</option><option>台中市</option><option>南投縣</option><option>彰化縣</option><option>雲林縣</option><option>嘉義市</option><option>嘉義縣</option><option>台南市</option><option>高雄市</option><option>屏東縣</option><option>花蓮縣</option><option>台東縣</option><option>澎湖縣</option><option>金門縣</option><option>連江縣</option></select>');
  	document.write('<select name="town" onChange="this.form.townVal.value=this.form.town.options[this.form.town.selectedIndex].text;"></select>');
  	document.write('<input name="memAdd" type="text" value="" size="48" maxlength="100">');
  	document.write('<input name="memCity" type="hidden" value="台北市">');
  	document.write('<input name="memDist" type="hidden" value="100中正區">');
	cityOnLoad(form.city,form.town);
}              