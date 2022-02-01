import reserveFilmBtn from "./reserveFilmBtn.js";



class homepageController{
    constructor() {
        this.initButtonObjects()
        this.selectedfilms = 0;
        this.hiddenCheckout = document.querySelectorAll(".hidden-div")
    }

    initButtonObjects(){
        const filmList = document.querySelectorAll(".film-info");

        filmList.forEach((film) => {
            new reserveFilmBtn(film, this);
        })
    }

    incrementSelectedFilms(){
        this.selectedfilms += 1;
        if (this.selectedfilms === 1){
            this.hiddenCheckout.forEach((button) => {
                button.hidden = false;
            })
            window.scrollBy(0, 135);
        }
    }

    decrementSelectedFilms(){
        this.selectedfilms -= 1;
        if (this.selectedfilms === 0){
            window.scrollBy(0, -135);
            this.hiddenCheckout.forEach((button) => {
                button.hidden = true;
            })
        }
    }
}

new homepageController();