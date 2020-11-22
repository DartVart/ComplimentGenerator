const onClick = () => {
    $.get('/compliment', (compliment) => {
        $("#compliment").text(compliment.text)
    })
}

$(document).ready(() => {
    $("#getComplimentButton").click(onClick)
})
