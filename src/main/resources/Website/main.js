let currentId = 0;

const mainParent = document.getElementById("main");

function AddProblem(title, room, description) {
    const aElement = document.createElement('a');

    const titleElement = document.createElement('h3')
    titleElement.innerText = title;

    const classTitleElement = document.createElement('p')
    classTitleElement.innerText = room;

    const checkbox = document.createElement('input');
    checkbox.id = "star";
    checkbox.type = "checkbox";
    checkbox.name = "star";

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
    problemMainElement.appendChild(checkbox);

    aElement.appendChild(problemyDiv);
    currentId++;
}

AddProblem("Problém s Wi-Fi připojením", "učebna A", "Slabý nebo žádný signál Wi-Fi.");
AddProblem("Chybný projektor", "učebna B", "Projektor se nezapíná.");
AddProblem("Zamrzlý počítač", "učebna C", "Počítač se zamrzne při spuštění.");
AddProblem("Nefungující tiskárna", "učebna D", "Tiskárna nevydává žádné výtisky.");
AddProblem("Zapomenuté heslo", "učebna E", "Student si nemůže přihlásit do systému.");
AddProblem("Nefungující reproduktory", "učebna F", "Reproduktory nevydávají žádný zvuk.");
AddProblem("Ztracený USB disk", "učebna G", "Uživatel nemůže najít připojené USB zařízení.");
AddProblem("Pomalu se načítající stránky", "učebna H", "Internet je příliš pomalý pro práci.");
AddProblem("Neaktuální software", "učebna I", "Počítače nemají aktualizovaný software.");
AddProblem("Zablokovaný účet", "učebna J", "Uživatel nemá přístup k účtu.");
AddProblem("Poškozený monitor", "učebna K", "Monitor nefunguje správně nebo má zlomenou obrazovku.");
AddProblem("Neplatný certifikát", "učebna L", "Prohlížeč zobrazuje chybu certifikátu.");
AddProblem("Nefunkční klávesnice", "učebna M", "Klávesnice nereaguje.");
AddProblem("Chyba připojení k projektoru", "učebna N", "Počítač se nemůže připojit k projektoru.");
AddProblem("Nesynchronizované hodiny", "učebna O", "Počítače ukazují nesprávný čas.");
AddProblem("Zablokovaný software", "učebna P", "Aplikace se nechce spustit.");
AddProblem("Nefungující myš", "učebna Q", "Myš nefunguje nebo nereaguje.");
AddProblem("Problém s přístupem k síti", "učebna R", "Počítač nemá přístup k síti.");
AddProblem("Poškozený USB port", "učebna S", "USB port nefunguje správně.");
AddProblem("Chyba při spouštění aplikace", "učebna T", "Aplikace neodpovídá při spuštění.");
AddProblem("Nečitelné texty na projektoru", "učebna U", "Projektor zobrazuje rozmazaný obraz.");
AddProblem("Problém se zabezpečením účtů", "učebna V", "Účty nejsou dostatečně zabezpečené.");
AddProblem("Špatná konfigurace IP adresy", "učebna W", "IP adresa není správně nastavena.");
AddProblem("Nefunkční síťový kabel", "učebna X", "Síťový kabel není připojen nebo je poškozen.");
AddProblem("Nefunkční kamera", "učebna Y", "Kamera není funkční.");
AddProblem("Problém se sdíleným diskem", "učebna Z", "Uživatelé nemají přístup ke sdílenému disku.");
AddProblem("Nefunkční hlášení chyb", "učebna A1", "Hlášení chyb nefunguje.");
AddProblem("Nefunkční webkamera", "učebna B1", "Webkamera nefunguje správně.");
AddProblem("Zablokovaný firewall", "učebna C1", "Firewall blokuje přístup k některým stránkám.");
AddProblem("Zaseknutý skener", "učebna D1", "Skener přestal pracovat.");
AddProblem("Pomalé přihlášení k účtu", "učebna E1", "Přihlášení trvá příliš dlouho.");
AddProblem("Nepřístupné síťové disky", "učebna F1", "Síťové disky nejsou dostupné.");
AddProblem("Problém se zálohováním dat", "učebna G1", "Data se nezálohují automaticky.");
AddProblem("Chybná instalace softwaru", "učebna H1", "Software nebyl správně nainstalován.");
AddProblem("Nefungující přihlašování přes biometriku", "učebna I1", "Biometrické přihlašování selhává.");
AddProblem("Slabý signál Wi-Fi", "učebna J1", "Wi-Fi signál je příliš slabý.");
AddProblem("Chybný antivirový software", "učebna K1", "Antivir nezachytává hrozby.");
AddProblem("Neoprávněný přístup k systému", "učebna L1", "Uživatelé mají neautorizovaný přístup.");
AddProblem("Poškozené napájecí kabely", "učebna M1", "Kabely jsou poškozené nebo opotřebované.");
AddProblem("Nefunkční diskové úložiště", "učebna N1", "Diskové úložiště se nezobrazuje.");
AddProblem("Problém s dálkovým ovladačem projektoru", "učebna O1", "Ovladač nefunguje.");
AddProblem("Neúplné aktualizace", "učebna P1", "Aktualizace se nainstalovala jen částečně.");
AddProblem("Konflikt IP adres", "učebna Q1", "Dvě zařízení mají stejnou IP adresu.");
AddProblem("Zamrzlý systém během práce", "učebna R1", "Systém zamrzne během běžné práce.");
AddProblem("Zpoždění v doručování e-mailů", "učebna S1", "E-maily chodí se zpožděním.");
AddProblem("Chybná konfigurace serveru", "učebna T1", "Server není správně nakonfigurován.");
AddProblem("Problém s VPN připojením", "učebna U1", "VPN připojení nefunguje.");
AddProblem("Nefunkční cloudové úložiště", "učebna V1", "Cloudové úložiště není dostupné.");
AddProblem("Chyba zabezpečení hesel", "učebna W1", "Hesla nejsou bezpečně uložena.");
AddProblem("Pomalý výkon počítače", "učebna X1", "Počítač reaguje velmi pomalu.");
AddProblem("Nefungující hlasová komunikace", "učebna Y1", "Mikrofon nebo sluchátka nefungují.");
AddProblem("Problém se vzdáleným přístupem", "učebna Z1", "Uživatelé nemají vzdálený přístup.");
AddProblem("Nefunkční notifikace", "učebna A2", "Notifikace v systému nefungují.");
AddProblem("Problém s přístupem k databázi", "učebna B2", "Databáze není dostupná.");
AddProblem("Špatné nastavení tiskárny", "učebna C2", "Tiskárna je špatně nastavena.");
AddProblem("Problém s bezpečnostními kamerami", "učebna D2", "Kamery nejsou funkční.");
AddProblem("Problém s instalací ovladačů", "učebna E2", "Ovladače nelze nainstalovat.");
AddProblem("Problém s výkonem serveru", "učebna F2", "Server pracuje pomalu.");
AddProblem("Nefungující vzdělávací platforma", "učebna G2", "Platforma pro výuku nefunguje.");
AddProblem("Chybná konfigurace routeru", "učebna H2", "Router není správně nastaven.");
AddProblem("Zamrzlé aplikace", "učebna I2", "Aplikace často zamrzají.");
AddProblem("Chyba při ukládání souborů", "učebna J2", "Soubory se neukládají správně.");
AddProblem("Nefunkční záložní zdroje", "učebna K2", "Záložní zdroj není funkční.");
AddProblem("Problém s přístupovými právy", "učebna L2", "Uživatelé nemají správné přístupy.");
AddProblem("Pomalé načítání dat", "učebna M2", "Data se načítají velmi pomalu.");
AddProblem("Chybějící licence na software", "učebna N2", "Software nemá platnou licenci.");

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