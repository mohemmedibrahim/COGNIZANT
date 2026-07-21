import CalculateScore from "./Components/CalculateScore";

function App() {
  return (
    <div>
      <CalculateScore
        Name="Steve"
        School="DNV Public School"
        total={284}
        goal={0.9467}
      />
    </div>
  );
}

export default App;