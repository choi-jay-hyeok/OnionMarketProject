function setDetailImage(event){
    for(var image of event.target.files){
        var reader = new FileReader();

        reader.onload = function(event){
            var img = document.createElement("img");
            img.setAttribute("src", event.target.result);
            img.setAttribute("style", "width: 130px; height: 130px; margin-left: 10px;");
            document.querySelector("div#images_container").appendChild(img);
        };

        console.log(image);
        reader.readAsDataURL(image);
    }
}