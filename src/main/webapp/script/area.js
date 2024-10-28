'use strict';

document.addEventListener("DOMContentLoaded", () => {
    let area = new Area(document.querySelector("svg.graph"));
    let radios = document.querySelectorAll("#coordinates-form input[type=radio][name=r]");
    for (let radio of radios) {
        radio.addEventListener("change", () => {
            area.setR(radio.value);
        });
    }
});

class Area {
    #element;
    #path;
    #isSettingRadius = false;
    constructor(element) {
        element.addEventListener("click", this.#clickPoint, {});
        this.#element = element;

        for (let i of this.#element.children) {
            if (i.matches("path")) {
                this.#path = i;
            }
        }
    }

    setR(r) {
        if (!this.#isSettingRadius) {
            for (let i of this.#element.children) {
                if (i.matches(".default")) {
                    i.setAttribute("visibility", "hidden");
                }
                if (i.matches(".scale")) {
                    i.setAttribute("visibility", "visible");
                }
            }
        }
        let transform = this.#path.getAttribute("transform");
        let new_transform = transform.replace(new RegExp(/scale(.*, .*)/), `scale(${r}, ${r})`);
        this.#path.setAttribute("transform", new_transform);
    }

    #clickPoint(event) {
        let point = event.currentTarget.createSVGPoint();
        point.x = event.clientX;
        point.y = event.clientY;
        point = point.matrixTransform(event.currentTarget.getScreenCTM().inverse());
        console.log(point.x, point.y);
        return point;
    }
}





