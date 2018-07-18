<script>
var d1 = Math.floor((Math.random()*30)+1);
var d2 = Math.floor((Math.random()*30)+1);
function formatDay(date){
    var m = date.getMonth()+1;
    var d = date.getDate();
    var opts = $(this).calendar('options');
    if (opts.month == m && d == d1){
        return '<div class="icon-ok md">' + d + '</div>';
    } else if (opts.month == m && d == d2){
        return '<div class="icon-search md">' + d + '</div>';
    }
    return d;
}
</script>
<style scoped="scoped">
.md{
    height:16px;
    line-height:16px;
    background-position:2px center;
    text-align:right;
    font-weight:bold;
    padding:0 2px;
    color:red;
}
</style>
