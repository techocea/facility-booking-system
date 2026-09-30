import { AppRouter } from "@/app/router"
import { AppProvider } from "@/app/providers"

export function App() {
  return (
    <AppProvider>
      <AppRouter />
    </AppProvider>
  )
}

export default App
