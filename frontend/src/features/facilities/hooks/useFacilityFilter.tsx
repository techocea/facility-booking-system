import type { Facility } from "@/features/facilities/types"
import { useMemo, useState } from "react"

export const useFacilityFilter = (facilities: Facility[] = []) => {
  const [minCapacity, setMinCapacity] = useState<number>(0)

  const filteredFacilities = useMemo(() => {
    return facilities.filter((item) => item.capacity >= minCapacity)
  }, [facilities, minCapacity])

  return {
    minCapacity,
    setMinCapacity,
    filteredFacilities,
  }

}