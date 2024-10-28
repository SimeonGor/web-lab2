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
        this.paint({x: 0, y: 0, width: 100, height: 100});
    }

    paint(r) {
        let width = this.#element.width
        let height = this.#element.height
        this.#path.setAttribute("d",
            "M100 150 l 0 100 l 50 0 l 0 -100 l 100 0 a 100 100 0 0 0 -100 -100 l -50 100 Z");
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





