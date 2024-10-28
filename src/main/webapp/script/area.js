document.addEventListener("DOMContentLoaded", () => {
    let area = new Area(document.getElementById("graph"));

});

class Area {
    #element;
    #path;
    constructor(element) {
        element.addEventListener("click", this.#clickPoint);
        this.#element = element;

        for (let i of this.#element.children) {
            if (i.matches("path")) {
                this.#path = i;
            }
        }
    }

    setR(r) {

    }

    #clickPoint(event) {
        let point = event.target.createSVGPoint();
        point.x = event.clientX;
        point.y = event.clientY;
        point = point.matrixTransform(event.target.getScreenCTM().inverse());
        console.log(point.x, point.y);
        return point;
    }
}





