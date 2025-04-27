# 🎬 Streaming-Service Binge Mode & ✈️ Airport Tower Simulator

---

## 📚 Описание проектов

### 🎬 Streaming-Service Binge Mode
Реализация системы для удобного просмотра сериалов на платформе.  
Клиентский код может итерироваться по эпизодам без знания их внутреннего хранения.

**Основные фишки:**
- Единый интерфейс `EpisodeIterator` для разных коллекций.
- Поддержка разных порядков просмотра:
  - Обычный (`SeasonIterator`)
  - Обратный (`ReverseSeasonIterator`)
  - Перемешанный (`ShuffleSeasonIterator`)
- Сезон (`Season`) поддерживает `Iterable<Episode>`, чтобы использовать `for-each`.
- `BingeIterator` — просмотр всех серий подряд по сезонам.

**Структура:**
- `Episode`, `Season`, `Series`
- `EpisodeIterator` + 3 варианта реализации
- `BingeIterator`

---

### ✈️ Airport Tower Simulator
Имитация работы аэропорта с диспетчерской башней через паттерн **Mediator**.

**Основные фишки:**
- Башня (`ControlTower`) управляет очередями на посадку/взлёт.
- Самолёты (`PassengerPlane`, `CargoPlane`, `Helicopter`) обмениваются сообщениями только через `TowerMediator`.
- Реализация экстренных ситуаций (`MAYDAY`) с немедленным получением полосы.

**Структура:**
- `TowerMediator` (интерфейс)
- `Aircraft` (абстрактный базовый класс)
- `ControlTower`, `PassengerPlane`, `CargoPlane`, `Helicopter`
- `SimulationDriver` — симуляция реального времени

---

## 📂 Структура проекта

binge-airport-simulator/ │ ├── README.md ├── .gitignore │ ├── src/ │ ├── binge/ │ │ └── (классы Binge Mode) │ └── airport/ │ └── (классы Airport Simulator) │ ├── uml/ │ ├── binge_mode_uml.png │ └── airport_tower_uml.png │ └── web/ ├── css/ │ └── style.css └── html/ └── index.html
