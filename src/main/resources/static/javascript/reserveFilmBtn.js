class ReserveFilmBtn {

    constructor(filmDiv, homepageController) {
        this.filmDiv = filmDiv
        this.button = filmDiv.querySelector(".btn");
        this.hController = homepageController;

        this.initButton()
    }

    get unSelectedText(){
        return "Click here to reserve film";
    }

    get selectedText(){
        return "Selected";
    }

    initButton(){
        this.button.textContent = this.unSelectedText;

        this.button.addEventListener("click", (event) =>{
            this.toggleSelected();
        });
    }

    toggleSelected() {
        this.filmDiv.classList.toggle("selected");
        if (this.filmDiv.classList.contains("selected")){
            this.button.textContent = this.selectedText;
            this.hController.incrementSelectedFilms()
        } else {
            this.button.textContent = this.unSelectedText;
            this.hController.decrementSelectedFilms()
        }
    }
}

export default ReserveFilmBtn;