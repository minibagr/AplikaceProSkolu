    let currentId = 0;

    const mainParent = document.getElementById("main");

    function AddProblem(title, room, description, date) {
        const aElement = document.createElement('a');

        const titleElement = document.createElement('h3')
        titleElement.innerText = title;

        const classTitleElement = document.createElement('p')
        classTitleElement.innerText = room;

        const checkbox = document.createElement('input');
        checkbox.id = "star";
        checkbox.type = "checkbox";
        checkbox.name = "star";
        
        const dateConst = document.createElement('h4');
        dateConst.innerHTML = date;

        const problemMainElement = document.createElement('h3');
        problemMainElement.classList.add("problem-main-info");

        const problemDescription = document.createElement('div');
        problemDescription.classList.add("problem-info");

        problemDescription.innerHTML = description;

        mainParent.appendChild(aElement);
        const problemyDiv = document.createElement('div');
        problemyDiv.classList.add('problemy');
        problemyDiv.setAttribute("id", currentId);
        problemyDiv.setAttribute("onclick", "ShowProblem(" + currentId + ")");

        problemyDiv.appendChild(problemMainElement);
        problemyDiv.appendChild(problemDescription);
        problemMainElement.appendChild(titleElement);
        problemMainElement.appendChild(classTitleElement);
        problemMainElement.appendChild(dateConst);
        //  problemMainElement.appendChild(checkbox);



        aElement.appendChild(problemyDiv);
        currentId++;
    }


    AddProblem("Chybný projektor", "učebna B", "Projektor se nezapíná.", "12");
AddProblem("Zamrzlý počítač", "učebna C", "Počítač se zamrzne při spuštění.", "29");
AddProblem("Nefungující tiskárna", "učebna D", "Tiskárna nevydává žádné výtisky.", "5");
AddProblem("Zapomenuté heslo", "učebna E", "Student si nemůže přihlásit do systému.", "7");
AddProblem("Nefungující reproduktory", "učebna F", "Reproduktory nevydávají žádný zvuk.", "3");
AddProblem("Ztracený USB disk", "učebna G", "Uživatel nemůže najít připojené USB zařízení.", "9");
AddProblem("Pomalu se načítající stránky", "učebna H", "Internet je příliš pomalý pro práci.", "2");
AddProblem("Neaktuální software", "učebna I", "Počítače nemají aktualizovaný software.", "28");
AddProblem("Zablokovaný účet", "učebna J", "Uživatel nemá přístup k účtu.", "6");
AddProblem("Poškozený monitor", "učebna K", "Monitor nefunguje správně nebo má zlomenou obrazovku.", "10");
AddProblem("Neplatný certifikát", "učebna L", "Prohlížeč zobrazuje chybu certifikátu.", "30");
AddProblem("Nefunkční klávesnice", "učebna M", "Klávesnice nereaguje.", "4");
AddProblem("Chyba připojení k projektoru", "učebna N", "Počítač se nemůže připojit k projektoru.", "8");
AddProblem("Nesynchronizované hodiny", "učebna O", "Počítače ukazují nesprávný čas.", "12");
AddProblem("Zablokovaný software", "učebna P", "Aplikace se nechce spustit.", "27");
AddProblem("Nefungující myš", "učebna Q", "Myš nefunguje nebo nereaguje.", "11");
AddProblem("Problém s přístupem k síti", "učebna R", "Počítač nemá přístup k síti.", "13");
AddProblem("Poškozený USB port", "učebna S", "USB port nefunguje správně.", "26");
AddProblem("Chyba při spouštění aplikace", "učebna T", "Aplikace neodpovídá při spuštění.", "14");
AddProblem("Nečitelné texty na projektoru", "učebna U", "Projektor zobrazuje rozmazaný obraz.", "1");
AddProblem("Problém se zabezpečením účtů", "učebna V", "Účty nejsou dostatečně zabezpečené.", "7");
AddProblem("Špatná konfigurace IP adresy", "učebna W", "IP adresa není správně nastavena.", "9");
AddProblem("Nefunkční síťový kabel", "učebna X", "Síťový kabel není připojen nebo je poškozen.", "2");
AddProblem("Nefunkční kamera", "učebna Y", "Kamera není funkční.", "6");
AddProblem("Problém se sdíleným diskem", "učebna Z", "Uživatelé nemají přístup ke sdílenému disku.", "10");
AddProblem("Nefunkční hlášení chyb", "učebna A1", "Hlášení chyb nefunguje.", "11");
AddProblem("Nefunkční webkamera", "učebna B1", "Webkamera nefunguje správně.", "29");
AddProblem("Zablokovaný firewall", "učebna C1", "Firewall blokuje přístup k některým stránkám.", "3");
AddProblem("Zaseknutý skener", "učebna D1", "Skener přestal pracovat.", "5");
AddProblem("Pomalé přihlášení k účtu", "učebna E1", "Přihlášení trvá příliš dlouho.", "8");
AddProblem("Nepřístupné síťové disky", "učebna F1", "Síťové disky nejsou dostupné.", "4");
AddProblem("Problém se zálohováním dat", "učebna G1", "Data se nezálohují automaticky.", "12");
AddProblem("Chybná instalace softwaru", "učebna H1", "Software nebyl správně nainstalován.", "13");
AddProblem("Nefungující přihlašování přes biometriku", "učebna I1", "Biometrické přihlašování selhává.", "30");
AddProblem("Slabý signál Wi-Fi", "učebna J1", "Wi-Fi signál je příliš slabý.", "14");
AddProblem("Chybný antivirový software", "učebna K1", "Antivir nezachytává hrozby.", "1");
AddProblem("Neoprávněný přístup k systému", "učebna L1", "Uživatelé mají neautorizovaný přístup.", "2");
AddProblem("Poškozené napájecí kabely", "učebna M1", "Kabely jsou poškozené nebo opotřebované.", "3");
AddProblem("Nefunkční diskové úložiště", "učebna N1", "Diskové úložiště se nezobrazuje.", "4");
AddProblem("Problém s dálkovým ovladačem projektoru", "učebna O1", "Ovladač nefunguje.", "6");
AddProblem("Neúplné aktualizace", "učebna P1", "Aktualizace se nainstalovala jen částečně.", "7");
AddProblem("Konflikt IP adres", "učebna Q1", "Dvě zařízení mají stejnou IP adresu.", "8");
AddProblem("Zamrzlý systém během práce", "učebna R1", "Systém zamrzne během běžné práce.", "9");
AddProblem("Zpoždění v doručování e-mailů", "učebna S1", "E-maily chodí se zpožděním.", "10");
AddProblem("Chybná konfigurace serveru", "učebna T1", "Server není správně nakonfigurován.", "11");
AddProblem("Problém s VPN připojením", "učebna U1", "VPN připojení nefunguje.", "12");
AddProblem("Nefunkční cloudové úložiště", "učebna V1", "Cloudové úložiště není dostupné.", "13");
AddProblem("Chyba zabezpečení hesel", "učebna W1", "Hesla nejsou bezpečně uložena.", "14");
AddProblem("Pomalý výkon počítače", "učebna X1", "Počítač reaguje velmi pomalu.", "28");
AddProblem("Nefungující hlasová komunikace", "učebna Y1", "Mikrofon nebo sluchátka nefungují.", "29");
AddProblem("Problém se vzdáleným přístupem", "učebna Z1", "Uživatelé nemají vzdálený přístup.", "1");
AddProblem("Nefunkční notifikace", "učebna A2", "Notifikace v systému nefungují.", "2");
AddProblem("Problém s přístupem k databázi", "učebna B2", "Databáze není dostupná.", "3");


    document.addEventListener("DOMContentLoaded", function () {
        const searchInput = document.getElementById("searchInput");
        const problems = document.querySelectorAll(".problemy");

        searchInput.addEventListener("input", function () {
            const searchTerm = searchInput.value.toLowerCase(); 

            problems.forEach(function (problem) {
                const problemTitle = problem.querySelector("h3").textContent.toLowerCase();

                if (problemTitle.includes(searchTerm)) {
                    problem.style.display = "block"; 
                } else {
                    problem.style.display = "none";
                }
            });
        });
    });


    function ShowProblem(id) {
        let problemDiv = document.getElementById(id);

        if(problemDiv.classList.contains("expand")) {
            problemDiv.classList.remove("expand");
        } else {
            problemDiv.classList.add("expand");
        }
    }

    let buttonCLick = 0;
    let originalOrder = [];
    
    document.addEventListener("DOMContentLoaded", function () {
        const problemsContainer = document.getElementById("main");
        const problems = Array.from(problemsContainer.querySelectorAll(".problemy"));
    
        originalOrder = problems.map(problem => problem);
    });
    
    function filterProblemsByDate() {
        const problemsContainer = document.getElementById("main");
        const problems = Array.from(problemsContainer.querySelectorAll(".problemy"));
    
        if (buttonCLick === 0) {
            problems.sort((a, b) => {
                const dateA = new Date(a.querySelector("h4").textContent.replace(/[()]/g, ""));
                const dateB = new Date(b.querySelector("h4").textContent.replace(/[()]/g, ""));
                return dateA - dateB;
            });
        } else if (buttonCLick === 1) {
            problems.sort((a, b) => {
                const dateA = new Date(a.querySelector("h4").textContent.replace(/[()]/g, ""));
                const dateB = new Date(b.querySelector("h4").textContent.replace(/[()]/g, ""));
                return dateB - dateA;
            });
        } else if (buttonCLick === 2) {
            problemsContainer.innerHTML = ""; 
            originalOrder.forEach(problem => problemsContainer.appendChild(problem)); 
            buttonCLick = -1;
        }
    
        if (buttonCLick !== -1) {
            problems.forEach(problem => problemsContainer.appendChild(problem));
        }
    
        buttonCLick++;
    }   

    const sortButton = document.getElementById("sortButton");
    sortButton.addEventListener("click", filterProblemsByDate);