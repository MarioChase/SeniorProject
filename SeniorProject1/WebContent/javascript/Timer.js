var global_tick;
function startTime() {
    var today = new Date();
    global_tick = today.getMilliseconds()%100;
    global_tick = setTimeout(startTime, 1);
}