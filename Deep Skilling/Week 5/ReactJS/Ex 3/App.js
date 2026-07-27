import CalculateScore from "./Components/CalculateScore";

function App() {
  return (
    <div>
      <CalculateScore
        name="Praveena"
        school="PSNA College of Engineering and Technology"
        total={480}
        goal={5}
      />
    </div>
  );
}

export default App;